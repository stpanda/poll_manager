CREATE TABLE "t_poll" (
  id SERIAL NOT NULL,
  name VARCHAR NOT NULL,
  start_date date NOT NULL,
  end_date date NOT NULL,
  is_activity BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE "t_question" (
  id SERIAL NOT NULL,
  title VARCHAR NOT NULL,
  poll_id BIGINT REFERENCES t_poll (id),
  PRIMARY KEY (id)
);