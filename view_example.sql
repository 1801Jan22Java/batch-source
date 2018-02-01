CREATE VIEW MY_VIEW AS
    SELECT ARTIST.NAME,
           ALBUM.TITLE
    FROM ALBUM
    INNER JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;
    
    select name from my_view where name like 'I%';
    create sequence idunno
    start with -5
    increment by -5;
    