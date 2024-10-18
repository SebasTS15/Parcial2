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

## Punto 1
1.	Crear una función en Oracle, que reciba como parámetro un texto el cual contenga el correo electrónico de una persona y éste debe ser validado bajo los siguientes criterios:

a.	Su longitud debe estar entre 10 y 30 caracteres
b.	Debe estar estructurado en 3 partes en la primera pueden ir solo números y letras (minúsculas o mayúsculas).
c.	La segunda parte debe estar concatenado con la primera y debe contener solo el signo @
d.	Y la tercera parte debe estar concatenado con la segunda y solo debe permitir el texto .com 
e.	Y la última parte de la cadena debe estar concatenada con la tercera y solo debe permitir el texto .co
Al final deberá retornar un mensaje indicando si es o no válido el correo enviado como parámetro.

```
CREATE OR REPLACE FUNCTION checkEmail( email VARCHAR)RETURN VARCHAR
IS
arroba  NUMBER;
com_parte NUMBER;
co_ parte NUMBER;
part_uno VARCHAR2(100);
part_dos VARCHAR2(1);
part_tres VARCHAR2(4);
part_cuatro VARCHAR2(3);
Begin
    IF LENGTH(email)BETWEEN 10 and 13 THEN
        return 'Es muy corto o largo el correo';
    END IF;
    
    arroba := INSTR(email,'@');
    IF arroba = 0 then
        return 'No exixte el arroba (@)';
    END IF;
    
    com_parte :=INSTR(email,'.com');
    IF com_parte = 0 or com_parte < arroba then
        return '"Correo no válido: falta o posición incorrecta de ".com"';
    END IF;
    
    co_parte := INSTR(email,'.co',3);
    IF co_parte = 0 or co_parte < com_parte then
        return '"Correo no válido: falta o posición incorrecta de ".co"';
    END IF;
        
    parte_uno := SUBSTR(email,1,arroba-1);
    IF REGEXP_LIKE(parte_uno,'^[A-Za-z0-9]+$') then
        return 'Correo no válido: primera parte incorrecta';
    END IF;
    
    parte_dos := SUBSTR(email,arroba,1);
    IF parte_dos != '@' then
        return 'Falta el @';
    END IF;
    
    parte_tres := SUBSTR(email,com_parte,4);
    IF parte_tres != '.com' then
        return 'Correo no válido: tercera parte incorrecta';
    END IF;
    
    parte_cuatro := SUBSTR(email,co_part,3);
    IF parte_cuatro != 'co' then
        return 'Correo no valido: cuarta parte incorrecta';
    END IF;
    return 'Correo valido';
END;
```
Llamado desde postman es:
http://localhost:8080/chekEmail/SebastianTunubala2@.com.co
