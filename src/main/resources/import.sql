
INSERT INTO playground(name,city,street_name,street_number,longitude,latitude) VALUES ("orlik","Lublin","Tumidajskiego","12",1.1,1.1);
INSERT INTO playground(name,city,street_name,street_number,longitude,latitude) VALUES ("orlik","Warszawa","Glowna","12",1.1,1.1);

INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_id,playground) VALUES ("2017-11-13",12.10,14.30,14,true,1,1);
INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_id,playground) VALUES ("2017-11-12",12.10,14.30,14,true,1,1);
INSERT INTO booking(date,start_order,end_order,max_number_of_player,is_available,leader_id,playground) VALUES ("2017-11-11",12.10,14.30,14,true,1,1);

INSERT INTO app_user(password,username) VALUES ("haslo","psosnowka");
INSERT INTO player(email,first_name,last_name,username) VALUES ("pawel@gmail.com","pawel","sosnowka","psosnowka");

INSERT INTO team(is_avaiable,leader_id,name) VALUES (true,1,"besteam");
