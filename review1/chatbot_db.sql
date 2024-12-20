CREATE DATABASE chatbot_db;
drop database chatbot_db;
USE chatbot_db;

CREATE TABLE chatbot_responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    response TEXT NOT NULL
);

INSERT INTO chatbot_responses (question, response) VALUES
('Hello', 'Hi there! How can I help you?'),
('What is your name?', 'I am a chatbot created to assist you.'),
('How are you?', 'I am just a program, but thanks for asking!'),
('What can you do?', 'I can answer your questions and provide information.'),
('Help', 'Sure! What do you need help with?');
select* from  chatbot_db.chatbot_responses;