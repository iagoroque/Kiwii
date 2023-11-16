-- SUBJECTS
    INSERT INTO subject (id, name) VALUES
    ('POO', 'Programação Orientada a Objetos');

-- RMS
    INSERT INTO rm (id, name, subject_id) VALUES
    ('200019492', 'Oseias Lopes da Silva', 'POO'),
    ('200019493', 'Iago Ribeiro Novaes', 'POO'),
    ('200019494', 'Harrison Borges dos Santos', 'POO');

-- LINKS
    INSERT INTO link (url, rm_id, subject_id) VALUES
    ('https://code.visualstudio.com/', '200019493', 'POO'),
    ('https://developer.mozilla.org/pt-BR/docs/Web/HTML', '200019494', 'POO'),
    ('https://youtu.be/S9uPNppGsGo?si=Nd4qJBbm8dkMb10d', '200019492', 'POO');
