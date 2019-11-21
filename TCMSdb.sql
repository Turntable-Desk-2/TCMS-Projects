drop table if exists customers;
drop table if exists projects;

create table customers(customer_id integer primary key not null, customer_name varchar(50) not null, customer_email varchar(50) not null, customer_address varchar(50) not null, customer_telephone varchar(20) not null, customer_level varchar(30) not null);
create table projects(project_id integer primary key not null, project_name varchar(50) not null,project_description varchar(100));

insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(001, "Isaac Agyen", "email@gmail.com", "Dome Pillar 2", "+233456789", "Gold");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(002, "Shadrack Ankomahene", "email1@gmail.com", "Dakoman", "+233234567", "Platinum");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(003, "Yaa Nuamah", "emai2@gmail.com", "Dansoman", "+2334534y5", "Premium");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(004, "Sam Bartels", "email3@gmail.com", "Taifa", "+23323456", "Gold");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(005, "Isaac Agyen", "email4@gmail.com", "Kotobabi", "+233498769", "Premium");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(006, "Yaw Newman", "email5@gmail.com", "kumasi", "+233456789", "Gold");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(007, "James Coleman", "emai5@gmail.com", "Sunyani St.1", "+23098765", "Gold");
insert into customers("customer_id", "customer_name", "customer_email", "customer_address", "customer_telephone", "customer_level") values(008, "Akwasi Boateng", "emai6@gmail.com", "oxford st.", "+2336543987", "Platinum");

insert into projects("project_id", "project_name", "project_description") values(101, "Heroku", "hosting Platform");
insert into projects("project_id", "project_name", "project_description") values(102, "Facebook", "social media");
insert into projects("project_id", "project_name", "project_description") values(103, "Security Camera", "home security");
insert into projects("project_id", "project_name", "project_description") values(104, "Data Science", "Analysis");
insert into projects("project_id", "project_name", "project_description") values(105, "Twitter", "social media");
insert into projects("project_id", "project_name", "project_description") values(106, "Instagram", "Social Media");
insert into projects("project_id", "project_name", "project_description") values(107, "Netbeans", "java IDE");
insert into projects("project_id", "project_name", "project_description") values(108, "Kwikly" "Food delivery app");
insert into projects("project_id", "project_name", "project_description") values(109, "netflix", "Movie Streaming app");
insert into projects("project_id", "project_name", "project_description") values(110, "TCMS", "Client Management System");