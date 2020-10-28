CREATE OR REPLACE PROCEDURE GET_PERSON_BY_ID  (
    p_id IN PERSON.ID%TYPE,
    result_cursor  OUT sys_refcursor  
)

AS

BEGIN
    OPEN result_cursor FOR select first_name,
    last_name,
    position,
     address from PERSON where ID=p_id;
        
END GET_PERSON_BY_ID;
/