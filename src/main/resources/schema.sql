CREATE TABLE "user" (
  username TEXT NOT NULL PRIMARY KEY,
  password TEXT NOT NULL
);

CREATE TABLE "note" (
  note_id SERIAL    NOT NULL PRIMARY KEY,
  author  TEXT      NOT NULL,
  created TIMESTAMP NOT NULL,
  text    TEXT      NOT NULL
);