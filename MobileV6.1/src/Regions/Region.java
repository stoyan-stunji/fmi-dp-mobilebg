package Regions;

public record Region
        (
                String area,
                String city
        )
{
        public String getAddress()
        {
                return city + ", " + area + " " + (int)(Math.random() * 10000);
        }
}
