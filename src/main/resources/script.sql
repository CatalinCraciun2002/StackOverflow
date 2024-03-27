CREATE TABLE users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_name VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50)
);

CREATE TABLE questions (
                           question_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           author_id BIGINT NOT NULL,
                           title VARCHAR(255) NOT NULL,
                           text TEXT NOT NULL,
                           picture_url VARCHAR(255),
                           creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (author_id) REFERENCES users(user_id)
);

CREATE TABLE answers (
                         answer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         question_id BIGINT NOT NULL,
                         author_id BIGINT NOT NULL,
                         text TEXT NOT NULL,
                         picture_url VARCHAR(255), -- URL to the picture
                         creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (question_id) REFERENCES questions(question_id),
                         FOREIGN KEY (author_id) REFERENCES users(user_id)
);

CREATE TABLE tags (
                      tag_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE question_tags (
                               question_id BIGINT,
                               tag_id BIGINT,
                               PRIMARY KEY (question_id, tag_id),
                               FOREIGN KEY (question_id) REFERENCES questions(question_id),
                               FOREIGN KEY (tag_id) REFERENCES tags(tag_id)
);

CREATE TABLE votes (
                       vote_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_id BIGINT NOT NULL,
                       vote_type VARCHAR(50) NOT NULL,
                       content_type VARCHAR(50) NOT NULL,
                       content_id BIGINT NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE INDEX idx_users_user_id ON users(user_id);
CREATE INDEX idx_questions_question_id ON questions(question_id);
CREATE INDEX idx_answers_answer_id ON answers(answer_id);
CREATE INDEX idx_tags_tag_id ON tags(tag_id);
CREATE INDEX idx_votes_vote_id ON votes(vote_id);

DROP TABLE IF EXISTS question_tags;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS votes;

```