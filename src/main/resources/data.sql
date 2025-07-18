-- Insert Users
INSERT INTO user (id, name, email, password, role) VALUES
(1, 'Sibirajen', 'sibirajen16@gmail.com', '$2a$12$Hl6rZJwqbi0pgDuFhNq8TeocGPQf8tKsak9LtYxJX.h/yCYtYrada', 'user');

-- Insert Tasks
INSERT INTO tasks (id, title, description) VALUES
(1, 'Learn Spring Boot', 'Go through CRUD operations using Spring Boot'),
(2, 'Finish React Frontend', 'Build the React UI for the Todo list app'),
(3, 'Prepare Resume', 'Update resume with latest project and skills'),
(4, 'Read Clean Code', 'Start reading Clean Code by Robert C. Martin');
