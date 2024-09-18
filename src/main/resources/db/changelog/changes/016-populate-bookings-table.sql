-- Inserare date în tabelul bookings
INSERT INTO bookings (id, user_id, table_id, booking_status, order_time, no_people, preferences, final_price)
VALUES
    (nextval('booking_id_seq'), 1, 1, 'COMPLETED', '2024-09-20 19:00:00', 4, 'Loc la fereastră', 150),
    (nextval('booking_id_seq'), 2, 2, 'IN_PROGRESS', '2024-09-20 20:00:00', 2, 'Lângă intrare', 80),
    (nextval('booking_id_seq'), 3, 3, 'CANCELED', '2024-09-21 18:00:00', 3, 'Zonă liniștită', 120),
    (nextval('booking_id_seq'), 1, 4, 'COMPLETED', '2024-09-22 21:00:00', 5, 'Sărbătoare', 200),
    (nextval('booking_id_seq'), 2, 5, 'COMPLETED', '2024-09-23 12:00:00', 2, 'Loc în aer liber', 90);
