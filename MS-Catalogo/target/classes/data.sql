INSERT INTO prestaciones (id, nombre, precio, descripcion) 
VALUES (1, 'Consulta Medicina General', 25000.0, 'Atención médica básica y derivaciones')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO prestaciones (id, nombre, precio, descripcion) 
VALUES (2, 'Consulta Psicología', 35000.0, 'Evaluación y terapia psicológica inicial')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO prestaciones (id, nombre, precio, descripcion) 
VALUES (3, 'Consulta Nutricional', 28000.0, 'Evaluación de peso y pauta alimenticia')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO boxes (id, codigo, centro_atencion) 
VALUES (1, 'BOX-101', 'Centro Médico Norte')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO boxes (id, codigo, centro_atencion) 
VALUES (2, 'BOX-102', 'Centro Médico Norte')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO boxes (id, codigo, centro_atencion) 
VALUES (3, 'BOX-201', 'Centro Médico Sur')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO cupos (id, box_id, fecha_hora_inicio, fecha_hora_fin, disponible) 
VALUES (1, 1, '2026-09-15 09:00:00', '2026-09-15 09:30:00', true)
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO cupos (id, box_id, fecha_hora_inicio, fecha_hora_fin, disponible) 
VALUES (2, 1, '2026-09-15 09:30:00', '2026-09-15 10:00:00', true)
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO cupos (id, box_id, fecha_hora_inicio, fecha_hora_fin, disponible) 
VALUES (3, 2, '2026-09-15 10:00:00', '2026-09-15 10:30:00', true)
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO cupos (id, box_id, fecha_hora_inicio, fecha_hora_fin, disponible) 
VALUES (4, 3, '2026-09-16 11:00:00', '2026-09-16 11:30:00', true)
ON DUPLICATE KEY UPDATE id=id;