CREATE TABLE usr (
                     id SERIAL PRIMARY KEY,
                     username VARCHAR(255) NOT NULL,
                     email VARCHAR(255) NOT NULL,
                     age INT NOT NULL,
                     weight INT NOT NULL,
                     height INT NOT NULL,
                     sex BOOLEAN NOT NULL,
                     aim VARCHAR(255) NOT NULL
);

CREATE TABLE food (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      calories INT NOT NULL,
                      proteins INT NOT NULL,
                      fats INT NOT NULL,
                      carbohydrates INT NOT NULL,
);

CREATE TABLE user_food (
                           user_id BIGINT NOT NULL,
                           food_id BIGINT NOT NULL,
                           when_ate TIMESTAMP NOT NULL,
                           PRIMARY KEY (user_id, food_id),
                           FOREIGN KEY (user_id) REFERENCES usr(id) ON DELETE CASCADE,
                           FOREIGN KEY (food_id) REFERENCES food(id) ON DELETE CASCADE
);
