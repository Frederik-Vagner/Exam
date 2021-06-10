INSERT INTO kommune (kode, navn) VALUES
(630, 'Vejle'),
(851, 'Aalborg'),
(230, 'Rudersdal'),
(820, 'Vesthimmerlands'),
(760, 'Rinkøbing-Skjern'),
(376, 'Guldborgsund');

INSERT INTO sogn (kode, navn, kommune_id, dato_for_nedlukning, positiv_procent) VALUES
(797, 'Givskud', 1, TO_DATE('03/07/2021', 'DD/MM/YYYY'), 3.66),
(836, 'Budolfi', 2, TO_DATE('30/05/2021', 'DD/MM/YYYY'), 3.11),
(836, 'Vor Frelsers', 2, TO_DATE('24/05/2021', 'DD/MM/YYYY'), 3.37),
(836, 'Vor Frue', 2, TO_DATE('04/06/2021', 'DD/MM/YYYY'), 2.34),
(931, 'Høsterkøb', 3, TO_DATE('29/05/2021', 'DD/MM/YYYY'), 2.81),
(828, 'Fovlum', 4, TO_DATE('13/04/2021', 'DD/MM/YYYY'), 12.24),
(877, 'Faster', 5, TO_DATE('12/05/2021', 'DD/MM/YYYY'), 6.16),
(798, 'Lindeballe', 1, TO_DATE('29/06/2021', 'DD/MM/YYYY'), 8.14),
(759, 'Vigsnøs', 6, TO_DATE('13/01/2021', 'DD/MM/YYYY'), 11.76),
(797, 'Vester', 1, TO_DATE('29/06/2021', 'DD/MM/YYYY'), 10.87);