package price;
import movie.Movie;
//����ʵ�ּ̳У���ͬ�ĵ�Ӱ����ɷ��ز�ͬ�ļƼۣ�Ȼ�󽫼۸��ٷ��ص����ļ�Ǯ��
public abstract class Price{
	public abstract int getPriceCode();
	public abstract double  getCharge(int days);
	public int getFrequentRenterPoints(int days) {
			return 1;
	}
}
