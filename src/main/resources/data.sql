-- SUBJECTS
    INSERT INTO Subject (id, name) VALUES 
    ('POO', 'Programação Orientada a Objetos'),
    ('GDC', 'Gestão do Conhecimento'),
    ('LPA', 'Lógica de Programação e Algoritmos');

-- STUDENTS
    INSERT INTO Rm (id, name) VALUES 
    ('100019492', 'Antônio Carlos Magalhães'),
    ('200019492', 'Oseias Lopes da Silva');

-- Associando Rm com Subject na tabela de associação
    INSERT INTO rm_subject (rm_id, subject_id) VALUES 
    ('100019492', 'GDC'),
    ('200019492', 'GDC'),
    ('200019492', 'LPA'),
    ('200019492', 'POO');

-- LINKS
    INSERT INTO link (url, rm_id, subject_id) VALUES
    ('https://code.visualstudio.com/', '200019492', 'POO');
