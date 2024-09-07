-- 코드를 입력하세요
SELECT temp.book_id as BOOK_ID, temp.AUTHOR_NAME as AUTHOR_NAME, DATE_FORMAT(temp.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM (
    SELECT books.*, auts.AUTHOR_NAME
    FROM BOOK books
    INNER JOIN AUTHOR auts
    ON books.AUTHOR_ID = auts.AUTHOR_ID
) temp
where temp.category = '경제'
order by temp.PUBLISHED_DATE;