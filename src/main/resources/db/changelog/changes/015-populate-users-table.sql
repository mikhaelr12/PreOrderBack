INSERT INTO users (id, username, password, email, phone)
VALUES
    (nextval('user_id_seq'), 'thomas', 'password123', 'john.doe@example.com', '060060060'),
    (nextval('user_id_seq'), 'jane', 'password456', 'jane.smith@example.com', '070070070'),
    (nextval('user_id_seq'), 'alice', 'password789', 'alice.jones@example.com', '080080080');
