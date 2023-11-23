-- SUBJECTS
    INSERT INTO subject (id, name) VALUES
    ('GDC', 'Gestão do Conhecimento'),
    ('POO', 'Programação Orientada a Objetos'),
    ('LPA', 'Lógica de Programação e Algoritmos'),
    ('BD', 'Banco de Dados');

-- RMS
    INSERT INTO rm (id, name, subject_id) VALUES
    ('100019492', 'André Carlos Magalhães', 'GDC'),
    ('200019492', 'Oseias Lopes da Silva', 'POO'),
    ('200019213', 'Iago Ribeiro Novaes', 'LPA'),
    ('200019494', 'Harrison Borges dos Santos', 'POO'),
    ('200017494', 'Marcos Carvalho Pacheco', 'GDC');

-- LINKS
    INSERT INTO link (url, rm_id, subject_id) VALUES
    ('https://code.visualstudio.com/', '200019213', 'POO'),
    ('https://developer.mozilla.org/pt-BR/docs/Web/HTML', '200019494', 'POO'),
    ('https://drive.google.com/file/d/1-awzfHVWIjKI_L_9rgX1rQzUJUneCcgf/view?usp=drive_link', '200019494', 'POO'),
    ('https://youtu.be/S9uPNppGsGo?si=Nd4qJBbm8dkMb10d', '200019492', 'POO'),
    ('https://drive.google.com/file/d/1masvpC5VlXzSpUPnBLjD0YOVkz7QMXE4/view?usp=sharing', '200019213', 'LPA'),
    ('https://drive.google.com/file/d/1jMBY4ecnwRULqvVyh9i81b5OMuHhT0u1/view?usp=sharing', '200019213', 'LPA'),
    ('https://docs.google.com/document/d/1U3dPasSmHI1CfxWZ6keETpJ_vSYd4tJp3O9Q3Td6RHg/edit?usp=sharing', '200017494', 'GDC'),
    ('https://drive.google.com/file/d/1P-Dv8Q7mHU2Nx5-S_-qrBpaWoN35a0oc/view?usp=sharing', '200019213', 'BD');
