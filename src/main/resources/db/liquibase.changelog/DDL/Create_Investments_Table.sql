
CREATE TABLE IF NOT EXISTS investments (
    id              UUID NOT NULL,
    user_id         UUID NOT NULL,
    name            VARCHAR(200) NOT NULL,
    type            VARCHAR(50),               -- Stock, Bond, MutualFund, etc.
    amount          DECIMAL(15,2),
    currency        VARCHAR(10),
    purchase_date   DATE,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP,

    CONSTRAINT pk_investments PRIMARY KEY (id),
    CONSTRAINT fk_investment_user
      FOREIGN KEY (user_id) REFERENCES users(id)
      ON DELETE CASCADE
);
