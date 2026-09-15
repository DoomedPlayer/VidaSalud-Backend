-- data.sql (ms-vidasalud-audit)
INSERT INTO auditoria_eventos (id, usuario_id, accion, fecha_hora, origen_ip, entidad_id, detalles)
VALUES (1, 'SYS-ADMIN', 'LOGIN', '2026-09-14 08:30:00', '192.168.1.10', NULL, 'Inicio de sesión exitoso')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO auditoria_eventos (id, usuario_id, accion, fecha_hora, origen_ip, entidad_id, detalles)
VALUES (2, 'RECEPCION-01', 'CREAR_CITA', '2026-09-14 09:15:22', '10.0.0.5', 'CITA-100', 'Cita creada para Medicina General')
ON DUPLICATE KEY UPDATE id=id;