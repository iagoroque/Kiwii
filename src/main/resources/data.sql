-- COURSES:
    INSERT INTO courses ( name, rm) VALUES 
    ('Bacharelado em Engenharia de Software', '{"200019492","200019213","200016717"}'),
    ('Análise e Desenvolvimento de Sistemas', '{"200019333","200019321","200016123"}');

-- SUBJECTS:
    INSERT INTO subjects (course_id, name, links) VALUES 
    (1, 'Gestão do Conhecimento', '{"1Waq2GevVK6fM4sTkMOzkKKh32Tme-LgN", "1vgzrnRUITFp_YYDztSlSgAioqRlSvUZ-"}'),
    (1, 'Programação Orientada a Objetos', '{"1Waq2GevVK6fM4sTkMOzkKKh32Tme-LgN", "1vgzrnRUITFp_YYDztSlSgAioqRlSvUZ-"}'),
    (2, 'Programação Orientada a Objetos', '{"1Waq2GevVK6fM4sTkMOzkKKh32Tme-LgN", "1vgzrnRUITFp_YYDztSlSgAioqRlSvUZ-"}'),
    (2, 'Lógica de Programação e Algoritmos', '{"1Waq2GevVK6fM4sTkMOzkKKh32Tme-LgN", "1vgzrnRUITFp_YYDztSlSgAioqRlSvUZ-"}');
