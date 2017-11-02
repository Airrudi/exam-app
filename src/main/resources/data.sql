INSERT INTO user (name, email, url) VALUES ('Henk', 'henk@email.nl', 'henk');

INSERT INTO exam (title, user_id, passing_percentage) VALUES ('proefexamen', 1, 60);
INSERT INTO exam (title, user_id, passing_percentage) VALUES ('examen 2', 1, 50);

INSERT INTO question (text, question_type) VALUES ('Hoe hoog is de Eiffeltoren?', 'MULTIPLE');
INSERT INTO question (text, question_type) VALUES ('Wat is het eerste automerk ter wereld?', 'MULTIPLE');

INSERT INTO exam_question (exam_id, question_id) VALUES (1, 1);
INSERT INTO exam_question (exam_id, question_id) VALUES (1, 2);

INSERT INTO answer (text, is_correct, question_id, score) VALUES ('100', false, 1, 0);
INSERT INTO answer (text, is_correct, question_id, score) VALUES ('200', false, 1, 0);
INSERT INTO answer (text, is_correct, question_id, score) VALUES ('300', true, 1, 10);
INSERT INTO answer (text, is_correct, question_id, score) VALUES ('400', false, 1, 0);

INSERT INTO answer (text, is_correct, question_id, score) VALUES ('BMW', false, 2, 0);
INSERT INTO answer (text, is_correct, question_id, score) VALUES ('Mercedes', true, 2, 0);
INSERT INTO answer (text, is_correct, question_id, score) VALUES ('Fiat', false, 2, 0);
INSERT INTO answer (text, is_correct, question_id, score) VALUES ('Alfa Romeo', false, 2, 0);

