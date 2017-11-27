
INSERT INTO playground(name,city,street_name,street_number,longitude,latitude) VALUES ("orlik","Lublin","Tumidajskiego","12",1.1,1.1);
INSERT INTO playground(name,city,street_name,street_number,longitude,latitude) VALUES ("orlik","Warszawa","Glowna","12",1.1,1.1);

INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_name,playground) VALUES ("2017-11-13",12.10,14.30,14,true,"psosnowka",1);
INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_name,playground) VALUES ("2017-11-12",12.10,14.30,14,true,"psosnowka",1);
INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_name,playground) VALUES ("2017-11-29",12.10,14.30,14,true,"psosnowka",1);

INSERT INTO app_user(password,username) VALUES ("haslo","psosnowka");
INSERT INTO player(email,first_name,last_name,username) VALUES ("pawel@gmail.com","pawel","sosnowka","psosnowka");

INSERT INTO team(is_avaiable,leader_name,name) VALUES (true,"psosnowka","bestteam");
INSERT INTO team(is_avaiable,leader_name,name) VALUES (true,"psosnowka","dreamteam");
INSERT INTO player_user_teams(set_of_users_id,user_teams_id) VALUES (1,1);
INSERT INTO player_user_teams(set_of_users_id,user_teams_id) VALUES (1,2);


INSERT INTO booking_players(booking_list_id,players_id) VALUES(1,1);
INSERT INTO booking_players(booking_list_id,players_id) VALUES(2,1);
INSERT INTO booking_players(booking_list_id,players_id) VALUES(3,1);

