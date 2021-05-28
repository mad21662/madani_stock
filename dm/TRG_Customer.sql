
CREATE OR REPLACE TRIGGER TRG_CUSTOMER
BEFORE INSERT OR UPDATE ON CUSTOMER
FOR EACH ROW
DECLARE 
BEGIN
    IF (INSERTING) THEN
        IF (:new.CREDITS < 0) THEN
          raise_application_error(-20001, 'The credits '|| :new.CREDITS ||' has to be greater or equal to 0');
        END IF;
        IF (:new.BIRTHDAY >= sysdate) THEN
          raise_application_error(-20002, 'The birthday ' || :new.BIRTHDAY || ' must be below the current date ( ' || sysdate || ' )!!');
        END IF;
    END IF;
    IF (UPDATING) THEN
        :new.BIRTHDAY := :old.BIRTHDAY ;
    END IF;
    IF NOT REGEXP_LIKE (:new.EMAIL, ' *@ *') THEN
      raise_application_error(-20003, 'The Email ( ' || :new.EMAIL || ' ) is not valid!!');
    END IF;
END TRG_CUSTOMER ;

Commit;