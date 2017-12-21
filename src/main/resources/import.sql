
INSERT INTO city(name,latitude,longitude)VALUES ("Lublin",51.246452,22.568445);
INSERT INTO city(name,latitude,longitude)VALUES ("Warszawa",52.237049,21.017532);
INSERT INTO city(name,latitude,longitude)VALUES ("Wrocław",51.107883,17.038538);
INSERT INTO city(name,latitude,longitude)VALUES ("Zdziłowice",50.81591,22.52749960);
INSERT INTO city(name,latitude,longitude)VALUES ("Opole",50.671062,17.926126);
INSERT INTO city(name,latitude,longitude)VALUES ("Olsztyn",53.770226,20.490189);
INSERT INTO city(name,latitude,longitude)VALUES ("Wrocławek",52.64817,19.0678);

INSERT INTO playground(name,category,description,street_name,street_number,latitude,longitude,city_id) VALUES ("orlik","Piłka nożna","Tatary","Tumidajskiego","12",51.259284, 22.589705,1);
INSERT INTO playground(name,category,description,street_name,street_number,latitude,longitude,city_id) VALUES ("orlik","Piłka nożna","Podzamcze","Aleje Racławickie","7",51.250520, 22.540410,1);

INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_name,playground) VALUES ("2017-11-13",12.10,14.30,14,true,"psosnowka",1);
INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_name,playground) VALUES ("2017-12-12",12.10,14.30,14,true,"psosnowka",1);
INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_name,playground) VALUES ("2017-12-29",12.10,14.30,14,true,"psosnowka",1);

INSERT INTO app_user(password,username) VALUES ("haslo","psosnowka");
INSERT INTO player(email,first_name,last_name,username) VALUES ("pawel@gmail.com","pawel","sosnowka","psosnowka");

INSERT INTO team(is_avaiable,leader_name,name) VALUES (true,"psosnowka","bestteam");
INSERT INTO team(is_avaiable,leader_name,name) VALUES (true,"psosnowka","dreamteam");
INSERT INTO player_user_teams(set_of_users_id,user_teams_id) VALUES (1,1);
INSERT INTO player_user_teams(set_of_users_id,user_teams_id) VALUES (1,2);


INSERT INTO booking_players(booking_list_id,players_id) VALUES(1,1);
INSERT INTO booking_players(booking_list_id,players_id) VALUES(2,1);
INSERT INTO booking_players(booking_list_id,players_id) VALUES(3,1);

