INSERT INTO items (id, dish_name, price, description, is_available, image, menu_id)
VALUES
    --Andys
    (nextval('item_id_seq'), 'Pizza Margherita', 95.00, 'Sos de roșii, cașcaval, busuioc proaspăt.', true, NULL, 1),
    (nextval('item_id_seq'), 'Pizza Pepperoni', 120.00, 'Sos de roșii, cașcaval, salami, paprika chili.', true, NULL, 1),
    (nextval('item_id_seq'), 'Pizza Rancho', 115.00, 'Sos de roșii, cașcaval, carne de pui, ciuperci conservate, maioneză, gogoșari conservați.', true, NULL, 1),
    (nextval('item_id_seq'), 'Pizza Bianca', 120.00, 'Cremă de brânză, frișcă, parmezan, cașcaval Mozzarela, șuncă Tambov, ciuperci champignon prăjite, busuioc, oregano.', true, NULL, 1),
    (nextval('item_id_seq'), 'Pizza 5 Cheeses', 115.00, 'Cașcaval, cremă de brânză, frișcă, mozzarella, parmezan, cașcaval Dor Blue, cașcaval Brie. ', true, NULL, 1),
    (nextval('item_id_seq'), 'Pizza Barbeque', 120.00, 'Sos de roșii, cașcaval, carne de pui, salami, bacon, sos BBQ, gogoșari conservați.', true, NULL, 1),
    (nextval('item_id_seq'), 'Pizza Fattoria', 120.00, 'Cașcaval, carne de pui, ciuperci champignion, frișcă, parmezan, ulei de trufe.', true, NULL, 1),

    --Corso
    (nextval('item_id_seq'), 'Pizza Mediterranean', 150.00, 'Mozzarella, creveți, ardei gras, rucola, sos de usturoi', true, NULL, 2),
    (nextval('item_id_seq'), 'Pizza Genovese', 150.00, 'Sos pizza, mozzarella, prosciutto crudo, rucola, roșii cherry, mozzarella bile, sos pesto.', true, NULL, 2),
    (nextval('item_id_seq'), 'Pizza Mexicană', 135.00, 'Sos pizza, mozzarella, saleami picant, porumb, măsline verzi.', true, NULL, 2),
    (nextval('item_id_seq'), 'Pizza Gusto', 140.00, 'Sos de pizza, file de pui afumat, mozzarella, rucola, roșii uscate, sos de usturoi, parmezan.', true, NULL, 2),
    (nextval('item_id_seq'), 'Pizza Fresca', 125.00, 'Sos de pizza, mozzarella, gorgonzola, rucola, roșii cherry, parmezan.', true, NULL, 2),
    (nextval('item_id_seq'), 'Pizza Furiosa', 135.00, 'Sos Pomodori pelati, mozzarella, bacon, salam, cabanos, ardei iute, chilly.', true, NULL, 2),
    (nextval('item_id_seq'), 'Pizza Rustică', 140.00, 'Pomodori pelati, mozzarella, şuncă, salam, cabanos, ciuperci, măsline, ardei gras.', true, NULL, 2),

    --La Placinte
    (nextval('item_id_seq'), 'Plăcintă cu praz și ou',55.00, 'Făină de grâu, chefir, ulei de floarea soarelui, praz, ou de găină, ceapă verde, mărar, condimente.', true, null, 3),
    (nextval('item_id_seq'), 'Salată cu ardei copt și cremă de brânză de oi',85.00, 'Brânză de oi, cremă de brânză, frișcă, ardei copt, ulei nerafinat, dressing pentru salată, verdeață, condimente, chiflă de secară.', true, null, 3),
    (nextval('item_id_seq'), 'Salată cu carne de curcan',130.00, 'Amestec de salată, carne de curcan, ardei dulce, măr, roșii, ou de prepeliță, dressing', true, null, 3),
    (nextval('item_id_seq'), 'Supă de ciuperci în pâine',80.00, 'Ceapă, cartofi, frișcă, ciuperci champignon, lapte, ulei de floarea soarelui, făină de grâu, sare, chiflă de secară pentru supa-cremă: făină de grâu, apă, făină de secară, malț de secară, maia de secară, sare, zahăr.
', true, null, 3),
    (nextval('item_id_seq'), 'Învârtită cu varză murată',47.00, 'Făină de grâu, apă potabilă, ulei de floarea soarelui, sare, varză murată, ceapă, condimente, ou de găină.', true, null, 3),
    (nextval('item_id_seq'), 'Învârtită cu brânză de vaci şi verdeaţa',67.00, 'Făină de grâu, apă potabilă, ulei de floarea soarelui, sare, brânză de vaci, ouă de găină, ceapă verde, mărar.', true, null, 3),
    (nextval('item_id_seq'), 'Plăcintă cu cartofi',47.00, 'Făină de grâu, chefir, cartofi, ceapă, ulei de floarea soarelui, condimente.', true, null, 3),

    --Foisor
    (nextval('item_id_seq'), 'Blinie cu becon și cașcaval',57.00, 'Clătite pufoase, servite cu bacon crocant și cașcaval topit.', true, null, 4),
    (nextval('item_id_seq'), 'Blinie cu icre roşii',130.00, 'Blinie pufoase cu icre roșii delicate, perfecte ca aperitiv savuros.', true, null, 4),
    (nextval('item_id_seq'), 'Blinie cu somon',80.00, 'Blinie pufoase cu somon afumat, o combinație fină și gustoasă.', true, null, 4),
    (nextval('item_id_seq'), 'Blinie cu pui, ciuperci în sos şi caşcaval',70.00, 'Blinie cu pui fraged, ciuperci în sos cremos și cașcaval topit.', true, null, 4),
    (nextval('item_id_seq'), 'Zeamă cu carne de pui',52.00, 'Ciorbă tradițională de pui, cu legume proaspete și gust acrișor.', true, null, 4),
    (nextval('item_id_seq'), 'Supă de ciuperci',45.00, 'Supă cremoasă de ciuperci, cu arome delicate și textură fină.', true, null, 4),
    (nextval('item_id_seq'), 'Borș roșu cu fasole',35.00, 'Borș roșu cu fasole, o ciorbă tradițională cu gust acrișor și bogat în proteine.', true, null, 4),

    --Torro Burgers
    (nextval('item_id_seq'), 'Chicken combo + Cola',99.00, 'Chicken burger+sos, Steakhouse fries, Coca-Cola 250 ml.', true, null, 5),
    (nextval('item_id_seq'), 'Combo American + Cola',89.00, 'American Burger + sos, Steakhouse Fries, Coca-Cola 250 ml.', true, null, 5),
    (nextval('item_id_seq'), 'Shrimp Burger',99.00, 'Сreveți tigru, sos aioli, roșii proaspete, castraveți, rucola, brânză Philadelphia și ghimbir murat!', true, null, 5),
    (nextval('item_id_seq'), 'American burger',64.00, 'Carne de vită, sos Torro, roșii, salata iceberg, ceapa marinata, cornișoni.', true, null, 5),
    (nextval('item_id_seq'), 'Blue cheeseburger',84.00, 'Carne de vită, sos Torro, roșii, salata iceberg, cornișoni, cașcaval Dorblue, ceapa confiată, becon, rucola.', true, null, 5),
    (nextval('item_id_seq'), 'Chicken burger',74.00, 'Steak de pui, sos vinegar, rucola, roșii, ceapa marinata, castraveți, cașcaval Cheddar american.', true, null, 5),
    (nextval('item_id_seq'), 'Falafel burger',59.00, 'Falafel, sos Torro, roșii, ceapa marinata , cornișoni, sos Sriracha', true, null, 5),

    --Pegas Burger
    (nextval('item_id_seq'), 'Royal Cheese',115.00, 'Castraveți, roșii. bacon, ceapă, salată, sos', true, null, 6),
    (nextval('item_id_seq'), 'Double Cheeseburger MIX',85.00, 'Castraveți murați, roșii, sos, ceapă, salată.', true, null, 6),
    (nextval('item_id_seq'), 'Double Burger de pui',75.00, 'Roșii, maioneză, salată.', true, null, 6),
    (nextval('item_id_seq'), 'Burger de vita',65.00, 'Ceapă, roșii, salată, sos', true, null, 6),
    (nextval('item_id_seq'), 'Cheeseburger de vita',70.00, 'Castraveți murați, roșii, sos, ceapă, salată.', true, null, 6),
    (nextval('item_id_seq'), 'American Cheeseburger',85.00, 'Muștar, castraveți murați, ketchup, ceapă.', true, null, 6),
    (nextval('item_id_seq'), 'Double Burger de vita',75.00, 'Ceapă, roșii, salată, sos', true, null, 6),

    --Esushi
    (nextval('item_id_seq'), 'Philadelphia Classic',175.00, 'Roll cu somon fresh, avocado și cream cheese.', true, null, 7),
    (nextval('item_id_seq'), 'Canada Classic',291.00, 'Țipar, somon, cream-cheese, avocado', true, null, 7),
    (nextval('item_id_seq'), 'California cu somon',198.00, 'Roll cu somon fresh, avocado și tobiko', true, null, 7),
    (nextval('item_id_seq'), 'Kinkaiy roll',207.00, 'Somon, creveți tempura, creamcheese, ardei copt, ananas', true, null, 7),
    (nextval('item_id_seq'), 'Chicken Ramen',131.00, 'Bulion de pui cu shiitake, șold de pui, udon, ou murat, ceapă', true, null, 7),
    (nextval('item_id_seq'), 'Tom Yum Clasic',169.00, 'Supă Tom Yum cu creveți și ciuperci negre de lemn. ', true, null, 7),
    (nextval('item_id_seq'), 'Miso ramen ebi tempura',158.00, 'Bulion miso, tăiței, creveți panko, ou murat, ceapă', true, null, 7),

    --Vasabi
    (nextval('item_id_seq'), 'Philadelphia Clasic',129.00, 'Somon, avocado, castraveți, cremă philadelphia.', true, null, 8),
    (nextval('item_id_seq'), 'Canada',195.00, 'Anghila afumată, somon, avocado, cremă philadelphia, susan', true, null, 8),
    (nextval('item_id_seq'), 'Crunch Shrimps',175.00, 'Creveți, icre tobico, tempura, castraveți, cremă philadelphia, susan, maioneză japoneză', true, null, 8),
    (nextval('item_id_seq'), 'Takusen',164.00, 'Creveți, icre tobico, maioneză japoneză, avocado.', true, null, 8),
    (nextval('item_id_seq'), 'Miso Ocean',95.00, 'Bulion miso, somon, biban, vakame, tofu, ciuperci shiitaki', true, null, 8),
    (nextval('item_id_seq'), 'Miso Classic',59.00, 'Bulion miso, ciuperci shiitaki, vakame, tofu', true, null, 8),
    (nextval('item_id_seq'), 'Karami Classic',129.00, 'Bulion karami, creveți, somon, biban, vakame', true, null, 8),

    --Starkebab
    (nextval('item_id_seq'), 'Starkebab pui',79.00, 'Lavaș, carne de pui, cartofi copți, salată de varză, verdeață, roșii proaspete, castraveți murați, sos roșu Harira, sos alb cu usturoi.', true, null, 9),
    (nextval('item_id_seq'), 'Starkebab pork',83.00, 'Lavaș, carne de porc, salată din varză, castraveți murați, ceapă roșie, cartofi copți, sos alb cu usturoi, sos BBQ,', true, null, 9),
    (nextval('item_id_seq'), 'Cheese Starkebab',85.00, 'Lavaș, carne de pui, cașcaval, brânza feta, salată de varză, castraveți proaspeți, sos Caesar, sos alb cu usturoi.', true, null, 9),
    (nextval('item_id_seq'), 'Starkebab Veggie',79.00, 'Lavaș, falafel, hummus, vânătă teriaki, ardei copt, salata Iceberg, sos alb de usturoi.', true, null, 9),
    (nextval('item_id_seq'), 'Family Box x3',245.00, '3 x Starkebab Pui + Coca Cola 1,25L', true, null, 9),
    (nextval('item_id_seq'), 'Family Box x5',395.00, '5 x Starkebab Pui + 2 x Coca Cola 1,25L', true, null, 9),
    (nextval('item_id_seq'), 'Family Box x7',545.00, '7 x Starkebab Pui + 3 x Coca Cola 1,25L', true, null, 9),

    --Twister
    (nextval('item_id_seq'), 'Twister Fitness',96.00, 'Lavas din făina integrala, Fileu de curcan, avocado, varza Pechin, salata Lola, roșii cherry, castraveți proaspeți, sos de iaurt', true, null, 10),
    (nextval('item_id_seq'), 'Twist de pui',84.00, 'Lavaș, carne de pui, cartofi pai, varză, castraveți murați, roșii, sos alb, sos roșu.', true, null, 10),
    (nextval('item_id_seq'), 'Black Twist de pui',86.00, 'Lavaș negru, carne de pui, cartofi pai, varză, castraveți murați, roșii, sos alb, sos roșu.', true, null, 10),
    (nextval('item_id_seq'), 'Twist de porc',89.00, 'Lavaș, carne de porc, cartofi pai, varză, castraveți murați, roșii, sos alb, sos roșu.', true, null, 10),
    (nextval('item_id_seq'), 'Falafel Veggie Twist',84.00, 'Falafel, cartofi pai, varza, roșii, castraveți murati, ketciup, sos.', true, null, 10),
    (nextval('item_id_seq'), 'Meniu Good Twist pui',132.00, 'Twist de pui, cartofi pai, sos alb, Coca-cola.', true, null, 10),
    (nextval('item_id_seq'), 'Meniu Good Twist porc',139.00, 'Twist de porc, cartofi pai, sos alb, Coca-cola.', true, null, 10)





