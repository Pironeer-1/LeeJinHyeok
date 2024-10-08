-- 코드를 작성해주세요

SELECT TEMP.ITEM_ID, TEMP.ITEM_NAME
FROM (
SELECT INFO.*, TREE.PARENT_ITEM_ID
FROM ITEM_INFO INFO
INNER JOIN ITEM_TREE TREE
ON INFO.ITEM_ID = TREE.ITEM_ID
) TEMP
WHERE TEMP.PARENT_ITEM_ID IS NULL;