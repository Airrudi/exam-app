package com.rc.examapp.exam;

import antlr.StringUtils;
import com.rc.examapp.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamRepository examRepository;

	public Exam save(Exam exam){
		return examRepository.save(exam);
	}

	public Exam findOne(Long examId) {
		return examRepository.findOne(examId);
	}


	// TODO: CODE DUPLICATION BELOW!
	/**
	 *
	 * @param exam Can be a "regular" exam to get the max score possible, but also a taken exam to calculate the score for the user (based on answered questions)
	 * @return the total score of the exam as an int, be aware that this is not the final grade, just the score (sum of all answers)
	 */
	@Override
	public int calculateScore(Exam exam) {

		// 1. Get all questions
		// 2. Get all correct answers (filter)
		Optional<Integer> optionalScore = exam.getQuestions().stream()
				.flatMap(q -> q.getAnswers().stream()) // Merge all answers into stream of given answers
				.filter(a -> a.isCorrect()) // Filter on correct answers
				.map(a -> a.getScore()) // Get all scores from these answers
				.reduce((a,b) -> a + b); // Add them all up

		return optionalScore.orElse(0);
	}

	@Override
	public int calculateScore(UserExam userExam) {

		// 1. Get all questions
		// 2. Get all correct answers (filter)
		Optional<Integer> optionalScore = userExam.getAnsweredQuestions().stream()
				.flatMap(q -> q.getGivenAnswers().stream()) // Merge all answers into stream of given answers
				.filter(a -> a.isCorrect()) // Filter on correct answers
				.map(a -> a.getScore()) // Get all scores from these answers
				.reduce((a,b) -> a + b); // Add them all up

		return optionalScore.orElse(0);
	}

	@Override
	public double calculateGrade(UserExam userExam) {
		double val = 0.0;

		int maxExamScore = calculateScore(userExam.getExam());
		if(maxExamScore == 0){maxExamScore = 0;} // An exam should never be allowed to be taken without any questions

		int takenExamScore = calculateScore(userExam);

		double grade = (double) takenExamScore / maxExamScore * 10;

		DecimalFormat df = new DecimalFormat("#.#");
		NumberFormat nf_in = NumberFormat.getNumberInstance(Locale.GERMANY);
		try {
			 val = nf_in.parse(df.format(grade)).doubleValue();

		} catch (ParseException e) {
			e.printStackTrace();

		}

		return val;


	}

	@Override
	public boolean isExamCompleted(UserExam userExam) {
		List<Question> examQuestions = userExam.getExam().getQuestions();
		List<Question> answeredExamQuestions = userExam.getAnsweredQuestions().stream().map(a -> a.getQuestion()).collect(Collectors.toList());

		return examQuestions.equals(answeredExamQuestions);
	}
}
