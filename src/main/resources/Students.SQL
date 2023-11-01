CREATE TABLE IF NOT EXISTS STUDENTS
(
    id           BIGSERIAL PRIMARY KEY,
    family       VARCHAR(50) NOT NULL,
    name         VARCHAR(50) NOT NULL,
    age          BIGINT      NOT NULL,
    group_number BIGINT      NOT NULL,
    total_score  BIGINT      NOT NULL
);

CREATE TABLE IF NOT EXISTS ITEM_RATINGS
(
    id         BIGSERIAL PRIMARY KEY,
    student_id BIGINT      NOT NULL,
    item       VARCHAR(50) NOT NULL,
    rating     BIGINT      NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE
);
