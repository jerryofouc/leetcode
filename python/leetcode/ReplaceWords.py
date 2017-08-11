class TrieNode:
    def __init__(self, value):
        self.value = value
        self.next_nodes = [None for i in xrange(26)]
        self.end = False
class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        root = TrieNode("")
        for word in dict:
            cur = root
            for i in word:
                if not cur.next_nodes[ord(i)-ord('a')]:
                    cur.next_nodes[ord(i)-ord('a')] = TrieNode(i)
                cur = cur.next_nodes[ord(i)-ord('a')]
                if cur.end:
                    break
            cur.end = True

        array = sentence.split(" ")
        for i in xrange(len(array)):
            k = self.replace_word(root,array[i])
            array[i] = k
        return " ".join(array)

    def replace_word(self,root,w):
        cur = root
        for i in xrange(len(w)):
            if not cur.next_nodes[ord(w[i])-ord('a')]:
                return w
            elif cur.next_nodes[ord(w[i])-ord('a')].end:
                return w[:i+1]
            else:
                cur = cur.next_nodes[ord(w[i])-ord('a')]
        return w


if __name__ == '__main__':
    s = Solution()
    print s.replaceWords(["cat", "bat", "rat"],"the cattle was rattled by the battery")



