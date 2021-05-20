CREATE TABLE "medication"
(
    "id"                       serial       NOT NULL,
    "name"                     VARCHAR(255) NOT NULL,
    "price"                    integer      NOT NULL,
    "count"                    integer      NOT NULL,
    "main_activity_ingredient" VARCHAR(255) NOT NULL,
    "code_product"             VARCHAR(255) NOT NULL,
    "type_id"                  VARCHAR(255) NOT NULL,
    CONSTRAINT "medication_pk" PRIMARY KEY ("id")
);

CREATE TABLE "report"
(
    "id"            serial       NOT NULL,
    "medication_id" integer      NOT NULL,
    "user_id"       integer      NOT NULL,
    "status"        BOOLEAN      NOT NULL,
    "count"         integer      NOT NULL,
    "total_cost"    integer      NOT NULL,
    "date"          VARCHAR(255) NOT NULL,
    CONSTRAINT "report_pk" PRIMARY KEY ("id")
);

ALTER TABLE "report"
    ADD CONSTRAINT "report_fk0" FOREIGN KEY ("medication_id") REFERENCES "medication" ("id");

INSERT INTO public.report(medication_id, user_id, status, count, total_cost, date)
VALUES (2, 2572, true, 2, 375, '24.05.2012');

INSERT INTO public.medication("name", price, "count", main_activity_ingredient, code_product, type_id)
VALUES ('Пеницилин', 252, 154, 'пениицилл', 12357, 'жидкость');
