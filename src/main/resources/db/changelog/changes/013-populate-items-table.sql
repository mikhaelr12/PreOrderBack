INSERT INTO items (id, dish_name, price, description, is_available, image, menu_id)
VALUES
    (nextval('item_id_seq'), 'Pizza Margherita', 55.00, 'Pizza italiană clasică cu mozzarella și busuioc', '1', NULL, 1),
    (nextval('item_id_seq'), 'Pizza Pepperoni', 65.00, 'Pizza cu pepperoni picant', '1', NULL, 1),

    (nextval('item_id_seq'), 'Rulou Sushi', 40.00, 'Rulou de sushi proaspăt cu avocado și castravete', '1', NULL, 2),
    (nextval('item_id_seq'), 'Tempura', 50.00, 'Legume și creveți încrustați în aluat crocant', '1', NULL, 2),

    (nextval('item_id_seq'), 'Chicken Tikka', 70.00, 'Pui la grătar cu condimente indiene', '1', NULL, 3),
    (nextval('item_id_seq'), 'Paneer Butter Masala', 75.00, 'Brânză de vaci în sos cremos de roșii', '1', NULL, 3),

    (nextval('item_id_seq'), 'Burger cu Carne de Vită', 50.00, 'Burger suculent cu carne de vită, brânză și salată', '1', NULL, 4),
    (nextval('item_id_seq'), 'Cartofi prăjiți', 25.00, 'Cartofi prăjiți crocanți și aurii', '0', NULL, 4),

    (nextval('item_id_seq'), 'Pasta Carbonara', 55.00, 'Paste cu sos cremos și pancetta', '1', NULL, 5),
    (nextval('item_id_seq'), 'Salată Caesar', 40.00, 'Salată proaspătă cu dressing Caesar', '1', NULL, 5),

    (nextval('item_id_seq'), 'Coaste BBQ', 90.00, 'Coaste gătite lent cu sos BBQ', '1', NULL, 6),
    (nextval('item_id_seq'), 'Salată Coleslaw', 30.00, 'Salată crocantă și acrișoară', '1', NULL, 6),

    (nextval('item_id_seq'), 'Sashimi', 65.00, 'Feliuțe de pește crud assortite', '0', NULL, 7),
    (nextval('item_id_seq'), 'Supa Miso', 35.00, 'Supa tradițională japoneză miso', '1', NULL, 7),

    (nextval('item_id_seq'), 'Spaghete Bolognese', 60.00, 'Spaghete cu sos bogat de carne', '1', NULL, 8),
    (nextval('item_id_seq'), 'Pâine cu Usturoi', 25.00, 'Pâine prăjită cu usturoi și unt', '1', NULL, 8),

    (nextval('item_id_seq'), 'Nuggets de Pui', 45.00, 'Nuggets de pui crocanți cu sos de înmuiat', '1', NULL, 9),
    (nextval('item_id_seq'), 'Inele de Ceapă', 30.00, 'Inele de ceapă prăjite și crocante', '1', NULL, 9),

    (nextval('item_id_seq'), 'Tacos', 40.00, 'Tacos picante cu carne de vită și salsa', '1', NULL, 10),
    (nextval('item_id_seq'), 'Guacamole', 30.00, 'Dip cremos de avocado cu chipsuri de tortilla', '1', NULL, 10);
