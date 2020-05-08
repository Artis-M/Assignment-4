public interface WriterInterface extends ReaderInterface
{
  void addValuable(Valuable valuable);

  Valuable retrieveValuable(int index);
}
