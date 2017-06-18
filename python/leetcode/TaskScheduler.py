class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        from collections import Counter
        count_dict = Counter(tasks)
        count_dict = sorted([(key,value) for key, value in count_dict.iteritems()],key=lambda tuple: -tuple[1])
        max_count = 0
        max_num = count_dict[0][1]
        for t in count_dict:
            if t[1] == max_num:
                max_count = max_count+1
            else:
                break

        return max(len(tasks)-max_count,(max_num-1)*(n+1))+max_count



if __name__ == '__main__':
    s = Solution()
    print s.leastInterval(['A','A','A','A','A','A','B','C','D','E','F','G'],2)