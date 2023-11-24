-- SUBJECTS
    INSERT INTO Subject (id, name) VALUES 
    ('POO', 'Programação Orientada a Objetos'),
    ('GDC', 'Gestão do Conhecimento'),
    ('LPA', 'Lógica de Programação e Algoritmos'),
    ('BD', 'Banco de Dados'),
    ('IA', 'Inteligência Artificial');

-- STUDENTS
    INSERT INTO Rm (id, name) VALUES 
    ('100019492', 'André Ricardo Magalhães'),
    ('200019492', 'Oseias Lopes da Silva'),
    ('200019213', 'Iago Roque Ribeiro Novaes'),
    ('200016717', 'Harrison Borges dos Santos'),
    ('200020478', 'Marcos Carvalho Pacheco');

-- Associando Rm com Subject na tabela de associação
    INSERT INTO rm_subject (rm_id, subject_id) VALUES 
    ('100019492', 'GDC'), -- André
    ('200019492', 'GDC'), -- Oseias
    ('200019492', 'LPA'),
    ('200019492', 'BD'),
    ('200019492', 'IA'),
    ('200019492', 'POO'),
    ('200019213', 'GDC'), -- Iago
    ('200019213', 'LPA'),
    ('200019213', 'BD'),
    ('200019213', 'IA'),
    ('200019213', 'POO'),
    ('200016717', 'GDC'), -- Harrison
    ('200016717', 'LPA'),
    ('200016717', 'BD'),
    ('200016717', 'IA'),
    ('200016717', 'POO'),
    ('200020478', 'GDC'), -- Marcos
    ('200020478', 'LPA'),
    ('200020478', 'BD'),
    ('200020478', 'IA'),
    ('200020478', 'POO');

-- LINKS
    INSERT INTO link (url, rm_id, subject_id) VALUES
    ('https://code.visualstudio.com/', '200019492', 'POO'), -- POO
    ('https://spring.io/', '200019213', 'POO'),
    ('https://discord.gg/vZgJcHet', '200020478', 'POO'),
    ('https://developer.mozilla.org/pt-BR/', '200016717', 'POO'),
    ('https://github.com/ucsal', '200019213', 'POO'),
    ('https://ucsal.br/', '200019492', 'GDC'), -- GDC
    ('https://github.com/iagoroque/Kiwii', '200019213', 'GDC'),
    ('https://www.computer.org/', '200020478', 'GDC'),
    ('https://drive.google.com/file/d/1masvpC5VlXzSpUPnBLjD0YOVkz7QMXE4/view?usp=drive_link', '200019213', 'LPA'), -- LPA
    ('https://git-scm.com/', '200016717', 'LPA'),
    ('https://www.youtube.com/watch?v=8mei6uVttho', '200019492', 'LPA'),
    ('https://github.com/iagoroque/Jogos-em-Java', '200019213', 'LPA'),
    ('https://www.coursera.org/learn/algorithms-part1', '200020478', 'LPA'),
    ('https://www.postgresql.org/', '200016717', 'BD'), -- BD
    ('https://www.w3schools.com/sql/', '200019492', 'BD'),
    ('https://drive.google.com/file/d/1P-Dv8Q7mHU2Nx5-S_-qrBpaWoN35a0oc/view?usp=sharing', '200019213', 'BD'),
    ('https://docs.oracle.com/en/database/', '200016717', 'BD'),
    ('https://learn.mongodb.com/', '200020478', 'BD'),
    ('https://www.python.org/', '200016717', 'IA'), -- IA
    ('https://openai.com/', '200019492', 'IA'),
    ('https://drive.google.com/file/d/1-xY-cJYGky4UJOPBbQlW76aalIIdcVT1/view?usp=sharing', '200019213', 'IA'),
    ('https://www.tensorflow.org/?hl=pt-br/', '200020478', 'IA'),
    ('https://colab.research.google.com/', '200016717', 'IA');
