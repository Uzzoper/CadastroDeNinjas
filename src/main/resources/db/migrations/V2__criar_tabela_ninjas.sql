CREATE TABLE ninjas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    img_url VARCHAR(255),
    idade INT,
    rank VARCHAR(50),
    missoes_id INT,
    CONSTRAINT fk_missoes
        FOREIGN KEY (missoes_id)
        REFERENCES missoes(id)
        ON DELETE SET NULL
);