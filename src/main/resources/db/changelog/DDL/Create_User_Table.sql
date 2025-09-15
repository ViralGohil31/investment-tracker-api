CREATE TABLE IF NOT EXISTS users (
    user_id         VARCHAR(50) PRIMARY KEY,   -- maps to Keycloak "sub"
    username        VARCHAR(100) NOT NULL,
    email           VARCHAR(150) UNIQUE,
    full_name       VARCHAR(200),
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS families (
    family_id       VARCHAR(50) PRIMARY KEY,
    family_name     VARCHAR(200) NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_family (
    user_family_id  VARCHAR(50) PRIMARY KEY,
    user_id         VARCHAR(50) NOT NULL,
    family_id       VARCHAR(50) NOT NULL,
    relationship    VARCHAR(50),   -- e.g. Head, Spouse, Child, Parent

    CONSTRAINT fk_user_family_user
      FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_user_family_family
      FOREIGN KEY (family_id) REFERENCES families(family_id) ON DELETE CASCADE
);

