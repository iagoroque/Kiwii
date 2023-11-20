-- SUBJECTS
    INSERT INTO subject (id, name) VALUES
    ('POO', 'Programação Orientada a Objetos');

-- RMS
    INSERT INTO rm (id, name, subject_id) VALUES
    ('100019492', 'André Carlos Magalhães', 'POO'),
    ('200019492', 'Oseias Lopes da Silva', 'POO'),
    ('200019213', 'Iago Ribeiro Novaes', 'POO'),
    ('200019494', 'Harrison Borges dos Santos', 'POO');

-- LINKS
    INSERT INTO link (url, rm_id, subject_id) VALUES
    ('https://code.visualstudio.com/', '200019213', 'POO'),
    ('https://developer.mozilla.org/pt-BR/docs/Web/HTML', '200019494', 'POO'),
    ('https://drive.google.com/file/d/1-awzfHVWIjKI_L_9rgX1rQzUJUneCcgf/view?usp=drive_link', '200019494', 'POO'),
    ('https://youtu.be/S9uPNppGsGo?si=Nd4qJBbm8dkMb10d', '200019492', 'POO');
