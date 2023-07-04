package MYSQL;

public class LEVEL3 {

	// ��ȸ���� ���� ���� �߰�ŷ� �Խ����� ÷������ ��ȸ�ϱ�
	SELECT concat("/home/grep/src/", a.BOARD_ID, "/", b.FILE_ID, b.FILE_NAME, b.FILE_EXT) as FILE_PATH
	FROM USED_GOODS_BOARD as a JOIN USED_GOODS_FILE as b ON a.BOARD_ID = b.BOARD_ID
	WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
	ORDER BY b.FILE_ID desc;
	
	
	//���ǿ� �´� ����� ���� ��ȸ�ϱ�
	SELECT DISTINCT b.USER_ID, b.NICKNAME, concat(b.CITY, " ", b.STREET_ADDRESS1, " " ,b.STREET_ADDRESS2) as ��ü�ּ�, CONCAT(LEFT(b.TLNO, 3), "-", MID(b.TLNO, 4, 4), "-", RIGHT(b.TLNO, 4)) as ��ȭ��ȣ
	FROM USED_GOODS_BOARD as a JOIN USED_GOODS_USER as b ON a.WRITER_ID = b.USER_ID
	WHERE
	b.USER_ID IN (SELECT WRITER_ID 
	FROM USED_GOODS_BOARD
	GROUP BY WRITER_ID
	HAVING COUNT(*) >= 3)
	ORDER BY b.USER_ID desc;
	
	select b.user_id as user_id, count(b.user_id) as Ƚ��, sum(s) as �ݾ�
	from (select cart_id, sum(price) as s from cart_products group by cart_id) a
	join carts b on a.cart_id = b.id
	group by b.user_id order by user_id;
	
	select b.id as id, b.distance as distance, count(case when b.best_date > = A.purchase_date
			and b.best_date �� trunc(A.purchase_date + 29, ��DD��) then 1 end) as CNT
	from (select user_id, purchase_date from purchase) a
			right join game_users b
			on b.id = a.user_id
			group by b.id, b.distance
			order by b.distance desc, b.id desc;
}
