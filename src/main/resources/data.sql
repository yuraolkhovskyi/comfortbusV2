insert into yuriiolkhovskiy.public.vehicle_stations(id, address, city, country)
values
    (1, 'BS-2, Khmelnytskogo Street, 2', 'Lviv', 0),
    (2, 'BS-1, Naukova Street, 66', 'Lutsk', 0),
    (3, 'BS-31, Novinski Street, 94', 'Lublin', 1),
    (4, 'BS-84, Gzezgozh Rovinski Street, 37', 'Warszawa', 1),
    (5, 'BS-84, Mariuszh Novinski Street, 17', 'Poznan', 1),
    (6, 'BS-84, Jadencgeer Street, 11', 'Brandenburg', 2),
    (7, 'BS-77, Deusbageee Street, 93', 'Bohum', 2),
    (8, 'BS-74, Jauneree Street, 23', 'Paris', 3),
    (9, 'BS-23, Nasponski Street, 68', 'Lublin', 1),
    (10, 'BS-1, Charovski Street, 334', 'Zamosc', 1);


insert into yuriiolkhovskiy.public.vehicles(id,
                                            additional_luggage,
                                            country_identifier,
                                            is_climate_control,
                                            is_double_decker,
                                            is_personal_seat_booking,
                                            is_rosette,
                                            is_tv,
                                            is_wifi,
                                            max_people,
                                            number_of_seats,
                                            personal_bicycle_place,
                                            pets_allowance,
                                            pwd_equipment,
                                            seat_belts,
                                            seat_light,
                                            status,
                                            toilet,
                                            type)
values
    (1, false, 'BC 3346 AO', true, false, true, false, true, true, 33, 25, false, false, false, true, false, 0, false, 1),
    (2, true, 'AC 4433 AT', true, true, true, true, true, true, 55, 50, true, true, true, true, true, 0, true, 2),
    (3, true, 'AS-852-XZ', true, true, true, true, true, true, 40, 46, true, true, true, true, true, 0, true, 2),
    (4, true, 'DD WW 6996', true, false, true, true, true, true, 30, 35, false, true, true, true, true, 0, true, 2),
    (5, true, 'PO 665 CS', true, false, true, true, true, true, 28, 34, false, true, true, true, true, 0, true, 1);


insert into yuriiolkhovskiy.public.passenger_seats(id, place_identifier, seat_row, vehicle_id)
values
    (1, 'A', 1, 2),
    (2, 'B', 1, 2),
    (3, 'C', 1, 2),
    (4, 'D', 1, 2),

    (5, 'A', 2, 2),
    (6, 'B', 2, 2),
    (7, 'C', 2, 2),
    (8, 'D', 2, 2),

    (9,  'A', 3, 2),
    (10, 'B', 3, 2),
    (11, 'C', 3, 2),
    (12, 'D', 3, 2),

    (13, 'A', 4, 2),
    (14, 'B', 4, 2),
    (15, 'C', 4, 2),
    (16, 'D', 4, 2),

    (17, 'A', 5, 2),
    (18, 'B', 5, 2),
    (19, 'C', 5, 2),
    (20, 'D', 5, 2),

    (21, 'A', 6, 2),
    (22, 'B', 6, 2),
    (23, 'C', 6, 2),
    (24, 'D', 6, 2),

    (25, 'A', 7, 2),
    (26, 'B', 7, 2),
    (27, 'C', 7, 2),
    (28, 'D', 7, 2);


insert into yuriiolkhovskiy.public.banking_card(id, number, cvc_code, expiration_date, owner, status)
values
    (1, '4657 7438 2583 2743', '123', '2023-06-01', 'Mariia Petrenko', 0),
    (2, '5374 2356 2389 3467', '942', '2026-08-10', 'Jack Rasbend', 0),
    (3, '8635 3425 7934 2369', '218', '2028-02-01', 'Joseph Jackson', 0),
    (4, '4657 7438 2583 2743', '123', '2023-06-01', 'Andrii Shevchenko', 0);

INSERT INTO yuriiolkhovskiy.public.users (id, email, firstname, lastname, password, registration_date, role)
VALUES
    (1, 'jackjack@gmail.com', 'Jack', 'Jack', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 0),
    (2, 'diff222@gmail.com', 'Peter', 'Janson', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 1),
    (3, 'janne572@gmail.com', 'Janne', 'Kero', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 2),
    (4, 'andrii357@gmail.com', 'Andrii', 'Lupashko', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 0),
    (5, 'yaroslavt69394@gmail.com', 'Yaroslav', 'Andrieiev', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 1),
    (6, 'pertro35221@gmail.com', 'Petro', 'Petriv', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 2),
    (7, 'jane35221@gmail.com', 'Jane', 'Jason', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 0),
    (8, 'ivan35221@gmail.com', 'Ivan', 'Ivanov', '$2a$10$t5Oe5eckAVHwQlmO7F4ypO2fkhAJjM.E49/eFIVoW0k/fN69TUiR2', '2023-01-01', 0);

insert into yuriiolkhovskiy.public.rides(id, departure_date, arrival_date, is_direct, price, status, administrator_id,
                                         arrival_station_id, departure_station_id, driver_id, vehicle_id)
values
    ('b33c7aea-e990-11ed-a05b-0242ac120003', '2023-06-01 13:00:00', '2023-06-01 22:00:00', true, 500, 0, 3, 4, 1, 2, 1),
    ('1a3779d4-e991-11ed-a05b-0242ac120003', '2023-06-26 12:50:00', '2023-06-26 22:50:00', true, 1500, 0, 6, 4, 1, 5, 2),
    ('22a1d8ee-e991-11ed-a05b-0242ac120003', '2023-06-01 06:00:00', '2023-06-01 23:00:00', false, 2000, 0, 3, 6, 2, 5, 5);

insert into yuriiolkhovskiy.public.tickets_bookings(id, additional_luggage_items, additional_user_comments, bicycle_items,
                                                    booking_date, payment_type, status, banking_card_id, client_id, ride_id)
values
    (1, 0, 'additional comments', 0, '2023-06-20', 0, 0, null, 1, '1a3779d4-e991-11ed-a05b-0242ac120003'),
    (2, 2, '-', 0, '2023-06-21 13:00:00', 1, 0, 2, 4, '1a3779d4-e991-11ed-a05b-0242ac120003'),
    (3, 0, '-', 1, '2023-06-22 14:00:00', 1, 0, 3, 7, '1a3779d4-e991-11ed-a05b-0242ac120003'),
    (4, 1, 'additional comments', 0, '2023-06-25 15:00:00', 1, 0, 4, 8, '1a3779d4-e991-11ed-a05b-0242ac120003');


INSERT INTO yuriiolkhovskiy.public.booking_passenger_seat (ticket_booking_id, passenger_seat_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (4, 9),
    (4, 10);

INSERT INTO yuriiolkhovskiy.public.intermediate_stops (id, stop_start_time, stop_end_time, ride_id, vehicle_station_id)
VALUES
    (1, '2023-06-26 13:30:00', '2023-06-26 13:40:00', '1a3779d4-e991-11ed-a05b-0242ac120003', 9),
    (2, '2023-06-26 20:30:00', '2023-06-26 20:40:00', '1a3779d4-e991-11ed-a05b-0242ac120003', 10);
