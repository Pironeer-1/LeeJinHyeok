-- 코드를 작성해주세요

SELECT SUM(temp.SCORE) as SCORE, EMP_NO, EMP_NAME, temp.POSITION, temp.EMAIL
from(
    SELECT employees.*, grades.SCORE
    FROM HR_EMPLOYEES employees
    INNER JOIN HR_GRADE grades
    ON employees.EMP_NO = grades.EMP_NO
) temp
GROUP BY EMP_NO, EMP_NAME, temp.POSITION, temp.EMAIL
ORDER BY SCORE DESC
LIMIT 1;