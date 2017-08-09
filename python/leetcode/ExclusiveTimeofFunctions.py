class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        mem = []
        for i in xrange(n):
            mem.append(0)

        stack = []
        for log in logs:
            l_array = log.split(":")
            log_num = int(l_array[0])
            log_time = int(l_array[2])
            if l_array[1] == 'start':
                stack.append([log_num,log_time])
            else:
                start_item = stack.pop()
                cur_len = log_time - start_item[1]+1
                mem[log_num] += cur_len
                for j in xrange(len(stack)):
                    stack[j][1] += cur_len

        return mem


if __name__ == '__main__':
    s = Solution()
    print s.exclusiveTime(2,["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"])

