# Parcial2
## Punto 3.
Deben crear una función en Oracle que reciba como parámetro una función y que permita validar si el número es o no múltiplo de 3.
### función en oracle
```
CREATE OR REPLACE FUNCTION PrimosTres ( num NUMBER) RETURN VARCHAR
IS
BEGIN
    IF num = 1 THEN
        return 'No es multiplo';
    END IF;
    for i in 3..FLOOR(SQRT(num))
        LOOP
            IF MOD(num,i)= 0 THEN
                return 'Es multiplo';
            END IF;
        END LOOP;
    RETURN 'No es multiplo';
END;
```
llamdo en postman.
http://localhost:8080/MultTres/9
