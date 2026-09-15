-- data.sql (ms-vidasalud-report)
INSERT INTO kpi_atenciones (id, fecha, atenciones_solicitadas, atenciones_confirmadas, atenciones_en_espera, atenciones_cerradas, atenciones_canceladas, tiempo_promedio_espera_minutos)
VALUES (1, '2026-09-13', 45, 40, 0, 38, 2, 14.5)
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO kpi_atenciones (id, fecha, atenciones_solicitadas, atenciones_confirmadas, atenciones_en_espera, atenciones_cerradas, atenciones_canceladas, tiempo_promedio_espera_minutos)
VALUES (2, '2026-09-14', 12, 10, 5, 2, 0, 8.2)
ON DUPLICATE KEY UPDATE id=id;