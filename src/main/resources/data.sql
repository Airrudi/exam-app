INSERT INTO exam (title, owner, passing_percentage) VALUES ('proefexamen', 'Henk', 60);
INSERT INTO exam (title, owner, passing_percentage) VALUES ('examen 2', 'Henk', 50);

INSERT INTO question (text, question_type) VALUES ('Hoe hoog is de Eiffeltoren?', 'MULTIPLE');
INSERT INTO question (text, question_type) VALUES ('Wat is het eerste automerk ter wereld?', 'MULTIPLE');

INSERT INTO exam_question (exam_id, question_id) VALUES (1, 1);
INSERT INTO exam_question (exam_id, question_id) VALUES (1, 2);

INSERT INTO answer (text, correct, question_id) VALUES ('100', false, 1);
INSERT INTO answer (text, correct, question_id) VALUES ('200', false, 1);
INSERT INTO answer (text, correct, question_id) VALUES ('300', true, 1);
INSERT INTO answer (text, correct, question_id) VALUES ('400', false, 1);

INSERT INTO answer (text, correct, question_id) VALUES ('BMW', false, 2);
INSERT INTO answer (text, correct, question_id) VALUES ('Mercedes', true, 2);
INSERT INTO answer (text, correct, question_id) VALUES ('Fiat', false, 2);
INSERT INTO answer (text, correct, question_id) VALUES ('Alfa Romeo', false, 2);

