use employee_management;

INSERT INTO employee_management.users (user_id, username, password) VALUES (1, 'ADMIN','$2a$12$jAle4p3FHdL9/3Mq9PUFYO.22JZNqwFnVNVGWC8Ii3C52lay2M09q');
INSERT INTO employee_management.users (user_id, username, password) VALUES (2, 'USER', '$2a$12$jAle4p3FHdL9/3Mq9PUFYO.22JZNqwFnVNVGWC8Ii3C52lay2M09q');

INSERT INTO employee_management.roles (role_id, name) VALUES (1, 'ADMIN');
INSERT INTO employee_management.roles (role_id, name) VALUES (2, 'USER');

INSERT INTO employee_management.users_roles (USER_ID, ROLE_ID) VALUES (1,1);
INSERT INTO employee_management.users_roles (USER_ID, ROLE_ID) VALUES (2,2);

INSERT INTO employee_management.employee (id, first_name, last_name, email) VALUES (1, 'Sai Kumar', 'Tuniki','sai@gmail.com');
INSERT INTO employee_management.employee (id, first_name, last_name, email) VALUES (2, 'Santosh Kumar', 'Tuniki','santosh@gmail.com');
INSERT INTO employee_management.employee (id, first_name, last_name, email) VALUES (3, 'Sai Vikas', 'Tuniki','vikas@gmail.com');
INSERT INTO employee_management.employee (id, first_name, last_name, email) VALUES (4, 'Sneha', 'Tuniki','sneha@gmail.com');