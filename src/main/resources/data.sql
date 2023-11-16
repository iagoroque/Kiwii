-- SUBJECTS
    INSERT INTO subjects (id, name) VALUES
    ('POO', 'Programação Orientada a Objetos');

-- RMS
    INSERT INTO rm (id, name, subject_id) VALUES
    ('200019492', 'Oseias Lopes da Silva', 'POO'),
    ('200019493', 'Iago Ribeiro Novaes','POO'),
    ('200019494', 'Harrison Borges dos Santos','POO');

-- LINKS
    INSERT INTO links (url, rm_id) VALUES
    ('https://www.java.com/pt-BR/', '200019493'),
    ('https://developer.mozilla.org/pt-BR/docs/Web/HTML', '200019494'),
    ('https://oseiasyc.github.io/', '200019492');
