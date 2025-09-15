CREATE TABLE IF NOT EXISTS investments (
    investment_id   VARCHAR(50) PRIMARY KEY,
    user_id         VARCHAR(50) NOT NULL,
    name            VARCHAR(200) NOT NULL,
    type            VARCHAR(50),               -- Stock, Bond, MutualFund, etc.
    amount          DECIMAL(15,2),
    currency        VARCHAR(10),
    purchase_date   DATE,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP,

    CONSTRAINT fk_investment_user
      FOREIGN KEY (user_id) REFERENCES users(user_id)
      ON DELETE CASCADE
);
