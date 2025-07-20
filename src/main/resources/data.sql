-- Insert Users
INSERT INTO users (name, email, password, role) VALUES
('Sibirajen', 'sibirajen16@gmail.com', '$2a$12$Hl6rZJwqbi0pgDuFhNq8TeocGPQf8tKsak9LtYxJX.h/yCYtYrada', 'user');

-- Insert Tasks
INSERT INTO tasks (title, description) VALUES
('Learn Spring Boot', 'Go through CRUD operations using Spring Boot'),
('Finish React Frontend', 'Build the React UI for the Todo list app'),
('Prepare Resume', 'Update resume with latest project and skills'),
('Read Clean Code', 'Start reading Clean Code by Robert C. Martin');
