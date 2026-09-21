-- Vehículos por tipo
SELECT
    placa,
    propietario,
    tipo,
    costo
FROM vehiculo
WHERE tipo = 'Automóvil';

-- Vehículos con costo mayor a Q50
SELECT
    placa,
    propietario,
    tipo,
    costo
FROM vehiculo
WHERE costo > 50;

-- Ordenados de mayor a menor costo
SELECT
    placa,
    propietario,
    tipo,
    costo
FROM vehiculo
ORDER BY costo DESC;