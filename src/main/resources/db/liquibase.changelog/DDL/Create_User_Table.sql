CREATE TABLE IF NOT EXISTS users (
    user_id         UUID PRIMARY KEY,   -- maps to Keycloak "sub"
    username        VARCHAR(100) NOT NULL,
    email           VARCHAR(150) UNIQUE,
    full_name       VARCHAR(200),
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS families (
    family_id       UUID PRIMARY KEY,
    family_name     VARCHAR(200) NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_family (
    user_family_id  UUID PRIMARY KEY,
    user_id         UUID NOT NULL,
    family_id       UUID NOT NULL,

    CONSTRAINT fk_user_family_user
      FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_user_family_family
      FOREIGN KEY (family_id) REFERENCES families(family_id) ON DELETE CASCADE
);

