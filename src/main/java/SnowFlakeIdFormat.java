public class SnowFlakeIdFormat {

    public static void main(String[] args) {
        snowFlakeIdFormat();
    }

    /**
     * <p>Intuition behind snow flake id generator.
     *
     * <p>How to generate 64 bit long unique and increasing id/number
     * <p>Total Bits = 64
     * <p>
     * -----------------------------------------------------------------------------
     * |0|  41 Bits TIMESTAMP  | 5 Bits DatacenterId| 5 Bits server Id| 12 bit seq |
     * -----------------------------------------------------------------------------
     */
    public static void snowFlakeIdFormat() {
        long timeStamp = 238053833149L;
        short dataCenterId = 28;
        short serverId = 16;
        int sequence = 193;

        // N bit number = 2 ^ N - 1
        //Max 5 bit number is 2^5 - 1 = 31, in HEX format  0x000000000000001F
        short maxDatacenterId = (short) (1L << 5) - 1;
        short maxServerId = (short) (1L << 5) - 1;

        System.out.println("UniqueID=" + (timeStamp << 22 | dataCenterId << 17 | serverId << 12 | sequence));

        long uniqueId = timeStamp << 22 | dataCenterId << 17 | serverId << 12 | sequence;

        //How to extract each part i.e. timestamp, datacenter-id,server-id,sequence from uniqueID
        System.out.println("extracting timeStamp    from uniqueId=" + ((uniqueId >> 22)));
        System.out.println("extracting dataCenterId from uniqueId=" + ((uniqueId >> 17) & 0x000000000000001F));
        System.out.println("extracting serverId     from uniqueId=" + ((uniqueId >> 12) & 0x000000000000001F));
        System.out.println("extracting sequence     from uniqueId=" + (uniqueId & 0x0000000000000FFF));
    }
}
